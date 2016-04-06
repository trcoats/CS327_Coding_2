package edu.bsu.cs327;

import java.util.ArrayList;
import java.util.HashMap;

public class Switching {
    ArrayList<HashMap> switchTable = new ArrayList<HashMap>();

    public String handleInput(String srcMacAddress, int portNumber, String destMacAddress) {
        String output = "";
        HashMap tableEntry = new HashMap();
        tableEntry.put(srcMacAddress, portNumber);
        for (HashMap hm : switchTable) {
            if (hm.containsKey(destMacAddress)) {
                output += "Port #: " + hm.get(destMacAddress).toString();
            } else {
                output += "Ports flooded";
            }
        }
        switchTable.add(tableEntry);
        return output;
    }

    public ArrayList<HashMap> getTable(){
        return switchTable;
    }

    public String frameErrorCheck(String macAddress) {
        String output = "";
        if (macAddress.length() != 6) {
            output += "Error: MAC address must be 6 bytes!";
        } else {
            output += "NoError";
        }
        return output;
    }

    public String portErrorCheck(int portNumber) {
        String output = "";
        if (portNumber > 24) {
            output += "Error: Port# not supported!";
        } else {
            output += "NoError";
        }
        return output;
    }


}