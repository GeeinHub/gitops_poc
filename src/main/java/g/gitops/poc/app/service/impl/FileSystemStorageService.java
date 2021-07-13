package g.gitops.poc.app.service.impl;


import g.gitops.poc.app.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootDir;

    public FileSystemStorageService() {
        this.rootDir = Paths.get("c:/temp");
    }

    public @Override void init() {
        try {
            Files.createDirectories(rootDir);
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    public @Override List<String> store(MultipartFile... files) {
        if (files.length > 0) {
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).forEach(file -> {
                String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                fileNames.add(filename);
                try {
                    if (file.isEmpty()) {
                        throw new RuntimeException("Failed to store empty file " + filename);
                    }
                    if (filename.contains("..")) {
                        throw new RuntimeException("Cannot store file with relative path outside current directory " + filename);
                    }
                    try (InputStream inputStream = file.getInputStream()) {
                        Files.copy(inputStream, this.rootDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Failed to store file " + filename, e);
                }
            });
            return fileNames;
        } else {
            throw new RuntimeException("Invalid request payload");
        }
    }

    public @Override Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootDir, 1)
                    .filter(path -> !path.equals(this.rootDir))
                    .map(this.rootDir::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }
    }

    public @Override Path load(String filename) {
        return this.rootDir.resolve(filename);
    }

    public @Override Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    public @Override void deleteAll() {
        FileSystemUtils.deleteRecursively(rootDir.toFile());
    }
}

