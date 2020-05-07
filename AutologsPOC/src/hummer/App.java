package hummer;

public class App {

  public App(String[] args){
     // AutoLog testLog = new AutoLog();
     // testLog.miles = 420.69f;
     // testLog.fillupAmount = 420.69f;
     // testLog.fillupCost = 420.69f;
     // testLog.note = "note";
     // testLog.location = "location";
     // testLog.coords = "coords";
     // testLog.vehicle = 1;
     // AutoLog newLog = AutologsServices.createLog(testLog);
     // newLog.display();
     //
     // newLog.miles = 69.42f;
     // newLog.fillupAmount = 69.42f;
     // newLog.fillupCost = 69.42f;
     AutoLog newLog = AutologsServices.getLog(16);
     newLog.miles = 489.21f;
     AutologsServices.updateLog(newLog);
     AutologsServices.getLog(16).display();

    // System.out.println("AutoLogs [");
    // for (AutoLog log : AutologsServices.getLogs()) {
    //   log.display();
    // }
    // System.out.println("]\n");


    // AutologsServices.getLog(1).display();


    // System.out.println("Vehicles [");
    // for (Vehicle vehicle : AutologsServices.getVehicles()) {
    //   vehicle.display();
    // }
    // System.out.println("]\n");


    // AutologsServices.getVehicle(1).display();

     // AutoLog deletedLog = AutologsServices.deleteLog(newLog.id);
     // deletedLog.display();
  }
}
