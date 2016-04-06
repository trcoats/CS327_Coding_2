package edu.bsu.cs327;

import java.util.ArrayList;
import java.util.HashMap;

public class Switching {
    ArrayList<HashMap<String, Integer>>switchTable = new ArrayList<HashMap<String, Integer>>();

    public String handleInput(String srcMacAddress, int portNumber, String destMacAddress){
        String output = "";
        HashMap tableEntry = new HashMap();
        tableEntry.put(srcMacAddress, portNumber);
        switchTable.add(tableEntry);
        for (HashMap hm : switchTable) {
            if (hm.containsKey(destMacAddress)) {
                output = hm.get(destMacAddress).toString();
            } else {
                output = "Ports flooded";
            }
        }
        return output;
    }

//    public String handleDestInput(String destMacAddress) {
//        String output = "";
//        for (HashMap hm : switchTable) {
//            if (hm.containsKey(destMacAddress)) {
//                output = hm.get(destMacAddress).toString();
//            } else {
//                output = "blah";
//            }
//        }
//        return output;
//    }

    public String frameErrorCheck(String macAddress){
        String output = "";
        if(macAddress.length() != 6){
            output += "Error: MAC address must be 6 bytes!";
        }
        return output;
    }

    public String portErrorCheck(int portNumber) {
        String output = "";
        if (portNumber > 24) {
            output += "Error: Port# not supported!";
        }
        return output;
    }
}
