cd front
call ng build
rd ..\src\main\resources\static\ddd-console /s /q
copy dist\ddd-console\*.* ..\src\main\resources\static