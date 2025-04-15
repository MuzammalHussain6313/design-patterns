package com.design.patterns.chainOfResposibility;

// Request class
class LeaveRequest {
    public String name;
    public int days;

    public LeaveRequest(String name, int days) {
        this.name = name;
        this.days = days;
    }
}

// Handler interface
abstract class LeaveApprover {
    protected LeaveApprover nextApprover;

    public void setNextApprover(LeaveApprover next) {
        this.nextApprover = next;
    }

    public abstract void approveLeave(LeaveRequest request);
}

// Concrete handler 1
class TeamLead extends LeaveApprover {
    public void approveLeave(LeaveRequest request) {
        if (request.days <= 2) {
            System.out.println("Team Lead approved leave for " + request.name);
        } else if (nextApprover != null) {
            nextApprover.approveLeave(request);
        }
    }
}

// Concrete handler 2
class Manager extends LeaveApprover {
    public void approveLeave(LeaveRequest request) {
        if (request.days <= 5) {
            System.out.println("Manager approved leave for " + request.name);
        } else if (nextApprover != null) {
            nextApprover.approveLeave(request);
        }
    }
}

// Concrete handler 3
class Director extends LeaveApprover {
    public void approveLeave(LeaveRequest request) {
        if (request.days <= 10) {
            System.out.println("Director approved leave for " + request.name);
        } else {
            System.out.println("Leave request denied for " + request.name + " (too many days)");
        }
    }
}

// Client
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        LeaveApprover teamLead = new TeamLead();
        LeaveApprover manager = new Manager();
        LeaveApprover director = new Director();

        // Setup chain
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);

        // Make some requests
        LeaveRequest request1 = new LeaveRequest("Alice", 1);
        LeaveRequest request2 = new LeaveRequest("Bob", 4);
        LeaveRequest request3 = new LeaveRequest("Charlie", 9);
        LeaveRequest request4 = new LeaveRequest("Dave", 12);

        teamLead.approveLeave(request1);
        teamLead.approveLeave(request2);
        teamLead.approveLeave(request3);
        teamLead.approveLeave(request4);
    }
}

