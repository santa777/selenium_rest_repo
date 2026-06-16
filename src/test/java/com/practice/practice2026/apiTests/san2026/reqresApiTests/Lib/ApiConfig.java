package com.practice.practice2026.apiTests.san2026.reqresApiTests.Lib;

public class ApiConfig {
    private static ApiConfig instance;
    private final String apiKey;

    // Private constructor prevents instantiation from other classes
    private ApiConfig() {
        // In a real scenario, you'd load this from a config file or Env variable
        // e.g., System.getenv("REQRES_API_KEY");
        this.apiKey = "pub_90788c02b35d922c91264eec13595a3d0985ac1976154ce3a9efe9bf9e4ac8db"; 
    }

    // Global access point
    public static ApiConfig getInstance() {
        if (instance == null) {
            synchronized (ApiConfig.class) {
                if (instance == null) {
                    instance = new ApiConfig();
                }
            }
        }
        return instance;
    }

    public String getApiKey() {
        return apiKey;
    }
}
