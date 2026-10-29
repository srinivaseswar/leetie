// ──────────────────────────────────────────────────
// Problem  : 468. Validate IP Address
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/validate-ip-address/
// Runtime  : 1 ms (beats 93%)
// Memory   : 42344000 (beats 91%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3) {
                return false;
            }
            // No leading zeros unless the part is exactly "0"
            if (part.charAt(0) == '0' && part.length() > 1) {
                return false;
            }
            int val = 0;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                val = val * 10 + (c - '0');
            }
            if (val > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 4) {
                return false;
            }
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                boolean isDigit = c >= '0' && c <= '9';
                boolean isLowerHex = c >= 'a' && c <= 'f';
                boolean isUpperHex = c >= 'A' && c <= 'F';
                if (!isDigit && !isLowerHex && !isUpperHex) {
                    return false;
                }
            }
        }
        return true;
    }
}