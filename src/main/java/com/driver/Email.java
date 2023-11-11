package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(this.password)) {
            if(checkPasswordValidity(newPassword)) {
                this.password = password;
            }
        }
    }

    private boolean checkPasswordValidity(String newPassword) {
        if(newPassword.length() < 8) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        for(int i=0; i<newPassword.length(); i++) {
            char c = newPassword.charAt(i);
            if(c >= 'A' || c <= 'Z') {
                containsUppercase = true;
            }else if(c >= 'a' || c <= 'z') {
                containsLowercase = true;
            }else if(c >= '0' || c <= '9') {
                containsDigit = true;
            }else {
                containsSpecialChar = true;
            }
        }
        if(containsDigit && containsLowercase && containsUppercase && containsSpecialChar) {
            return true;
        }
        return false;
    }
}
