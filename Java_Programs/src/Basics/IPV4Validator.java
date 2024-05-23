package Basics;

public class IPV4Validator {

    // Method to validate an IPv4 address
    public static boolean isValidIPv4(String ipAddress) {
        // Split the IP address into its components (octets)
        String[] octets = ipAddress.split("\\.");

        // Check if the address has 4 octets
        if (octets.length != 4)
            return false;

        // Validate each octet
        for (String octet : octets) {
            // Check if each octet is empty or has leading zeros
            if (octet.isEmpty() || (octet.length() > 1 && octet.startsWith("0")))
                return false;

            // Check if each octet is a number between 0 and 255
            int num;
            try {
                num = Integer.parseInt(octet);
            } catch (NumberFormatException e) {
                // If parsing fails, the octet is not a number
                return false;
            }
            if (num < 0 || num > 255)
                return false;
        }

        // If all checks pass, the address is valid
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {"192.168.0.1", "255.255.255.0", "10.10.10.10", "300.200.100.50", "abc.def.ghi.jkl"};

        for (String ipAddress : testCases) {
            System.out.println(ipAddress + " is valid: " + isValidIPv4(ipAddress));
        }
    }
}
