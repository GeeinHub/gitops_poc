package g.gitops.poc.app.service;

public interface RuleAppService {
    String checkEdiRule(String module, String customerCode);
    String matchCsv(String serviceOffice);
    String checkMilestoneRule(String milestoneCode, String customerCode);
}
