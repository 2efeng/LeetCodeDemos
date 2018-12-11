package com.hzf.leetcode._929numUniqueEmails;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zf.huang on 2018.12.7
 */
public class Solution {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(emails));
    }

    private int numUniqueEmails(String[] emails) {
        Set<String> emailsList = new HashSet<>();
        for (String email : emails) {
            String name = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@"));
            emailsList.add(name.substring(0, name.indexOf("+")).replace(".", "") + domain);
        }
        return emailsList.size();
    }
}
