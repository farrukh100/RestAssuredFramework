package core.configuration;

import core.configuration.testProperties.PropertiesLoader;
import core.configuration.testProperties.Property;
import core.configuration.testProperties.PropertyFile;

@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("Device")
    private String Device ="";
    @Property("project")
    private String project = "";
    @Property("projectKey")
    private String projectKey = "";
    @Property("cycleName")
    private String cycleName = "";
    @Property("releaseVersion")
    private String releaseVersion = "";

    @Property("userName")
    private String userName = "";
    @Property("password")
    private String password = "";

    @Property("environment")
    private String environment = "";
    @Property("isEnableReporting")
    private String isEnableReporting = "";

//##################### --- KeyCloak Settings --- #####################

    @Property("grant_type")
    private String grant_type = "";

    @Property("client_id")
    private String client_id = "";

    @Property("client_secret")
    private String client_secret = "";

    //##################### --- Settings Respective to Environments --- #####################
    //                      ############ --- PERF --- ############
    @Property("PERF_keyCloakUri")
    private String PERF_keyCloakUri = "";
    @Property("PERF_baseUri")
    private String PERF_baseUri = "";
    @Property("PERF_port")
    private String PERF_port = "";

    //                                 # --- DB --- #
    @Property("PERF_dbUrl")
    private String PERF_dbUrl = "";
    @Property("PERF_dbUserName")
    private String PERF_dbUserName = "";
    @Property("PERF_dbPassword")
    private String PERF_dbPassword = "";

    //                      ############ --- QA --- ############
    @Property("QA_keyCloakUri")
    private String QA_keyCloakUri = "";
    @Property("QA_baseUri")
    private String QA_baseUri = "";
    @Property("QA_port")
    private String QA_port = "";

    //                                 # --- DB --- #
    @Property("QA_dbUrl")
    private String QA_dbUrl = "";
    @Property("QA_dbUserName")
    private String QA_dbUserName = "";
    @Property("QA_dbPassword")
    private String QA_dbPassword = "";

    //                      ############ --- DEV --- ############
    @Property("DEV_keyCloakUri")
    private String DEV_keyCloakUri = "";
    @Property("DEV_baseUri")
    private String DEV_baseUri = "";
    @Property("DEV_port")
    private String DEV_port = "";

    //                                 # --- DB --- #
    @Property("DEV_dbUrl")
    private String DEV_dbUrl = "";
    @Property("DEV_dbUserName")
    private String DEV_dbUserName = "";
    @Property("DEV_dbPassword")
    private String DEV_dbPassword = "";

    //                      ############ --- UAT --- ############
    @Property("UAT_keyCloakUri")
    private String UAT_keyCloakUri = "";
    @Property("UAT_baseUri")
    private String UAT_baseUri = "";
    @Property("UAT_port")
    private String UAT_port = "";

    //                                 # --- DB --- #
    @Property("UAT_dbUrl")
    private String UAT_dbUrl = "";
    @Property("UAT_dbUserName")
    private String UAT_dbUserName = "";
    @Property("UAT_dbPassword")
    private String UAT_dbPassword = "";



    public String getDevice() {return Device;}
    public String getProject() {
        return project;
    }
    public String getProjectKey() {
        return projectKey;
    }
    public String getCycleName() {
        return cycleName;
    }
    public String getReleaseVersion() {
        return releaseVersion;
    }

    public String getUserName() {return userName;}
    public String getPassword() {return password;}

    public String getEnvironment() {return environment;}
    public String getIsEnableReporting() {return isEnableReporting;}

//##################### --- KeyCloak Settings --- #####################

    public String getGrantType() {
        return grant_type;
    }
    public String getClientId() {
        return client_id;
    }
    public String getClientSecret() {
        return client_secret;
    }


//##################### --- Settings Respective to Environments --- #####################
//                      ############ --- PERF --- ############

    public String getPERF_baseUri() {
        return PERF_baseUri;
    }

    //                                 # --- DB --- #
    public String getPERF_dbUrl() { return PERF_dbUrl; }
    public String getPERF_dbUserName() { return PERF_dbUserName; }
    public String getPERF_dbPassword() { return PERF_dbPassword; }

//                      ############ --- QA --- ############

    public String getQA_baseUri() {
        return QA_baseUri;
    }

    //                                 # --- DB --- #
    public String getQA_dbUrl() { return QA_dbUrl; }
    public String getQA_dbUserName() { return QA_dbUserName; }
    public String getQA_dbPassword() { return QA_dbPassword; }

//                      ############ --- DEV --- ############

    public String getDEV_baseUri() {
        return DEV_baseUri;
    }

    //                                 # --- DB --- #
    public String getDEV_dbUrl() { return DEV_dbUrl; }
    public String getDEV_dbUserName() { return DEV_dbUserName; }
    public String getDEV_dbPassword() { return DEV_dbPassword; }

//                      ############ --- UAT --- ############

    public String getUAT_baseUri() {
        return UAT_baseUri;
    }

    //                                 # --- DB --- #
    public String getUAT_dbUrl() { return UAT_dbUrl; }
    public String getUAT_dbUserName() { return UAT_dbUserName; }
    public String getUAT_dbPassword() { return UAT_dbPassword; }

}
