package g.gitops.poc.domain.testdata;

import g.gitops.poc.domain.milestone.entity.Milestone;

import java.util.Date;

public class MilestoneData {
    public static Milestone milestone1(){
        Milestone milestone1 = new Milestone();
        milestone1.setReferenceId("TestPO1");
        milestone1.setReferenceType("PO");
        milestone1.setId("XXX1");
        milestone1.setMilestoneCode("PO Created");
        milestone1.setExpectedDate(new Date());
        return milestone1;
    }

    public static Milestone milestone2(){
        Milestone milestone2 = new Milestone();
        milestone2.setReferenceId("TestPO1");
        milestone2.setReferenceType("PO");
        milestone2.setId("XXX2");
        milestone2.setMilestoneCode("Doc Uploaded");
        milestone2.setExpectedDate(new Date());
        return  milestone2;
    }
}
