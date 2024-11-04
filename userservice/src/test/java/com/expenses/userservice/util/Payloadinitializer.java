package com.expenses.userservice.util;

public class Payloadinitializer {


    public static String  createUserWithRoleNameOnlyData(){
        return "{\n" +
                "  \"email\": \"gopichand@gmail.com\",\n" +
                "  \"username\": \"gopi\",\n" +
                "  \"password\": \"fddf\",\n" +
                "  \"userRoles\": [\n" +
                "    {\n" +
                "      \"roleName\": \"APP_ADMIN\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String creatUserWithOnlyUserRole(){
        return"{\n" +
                "  \"email\": \"gopichand1@gmail.com\",\n" +
                "  \"username\": \"gopi2\",\n" +
                "  \"password\": \"fddf\",\n" +
                "  \"userRoles\": [\n" +
                "    {\n" +
                "      \"roleName\": \"APP_USER\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
