package edu.bsu.cs327;

public class Switching {
    public String frameErrorCheck(String macAddress){
        String output = "";
        if(macAddress.length() != 6){
            output += "Error: MAC address must be 6 bytes!";
        }
        else{
            //run program
        }
        return output;
    }

    public String portErrorCheck(int portNumber){
        String output = "";
        if (portNumber > 24){
            output += "Error: Port# not supported!";
        }
        else{
            //runProgram
        }
        return output;
    }

}
