package core.configuration;

public class configProperties {
    public static TestsConfig appConfig = new TestsConfig();

    public String Device = appConfig.getDevice();

    public String UserName = appConfig.getUserName();
    public String Password = appConfig.getPassword();

    public String Environment = appConfig.getEnvironment();
    public String isEnableReporting = appConfig.getIsEnableReporting();

//##################### --- Settings Respective to Environments --- #####################

    //                      ############ --- PERF --- ############
    public String PERF_baseUri = appConfig.getPERF_baseUri();
    //                                 # --- DB --- #
    public String PERF_dbUrl = appConfig.getPERF_dbUrl();
    public String PERF_dbUserName = appConfig.getPERF_dbUserName();
    public String PERF_dbPassword = appConfig.getPERF_dbPassword();

    //                      ############ --- QA --- ############
    public String QA_baseUri = appConfig.getQA_baseUri();
    //                                 # --- DB --- #
    public String QA_dbUrl = appConfig.getQA_dbUrl();
    public String QA_dbUserName = appConfig.getQA_dbUserName();
    public String QA_dbPassword = appConfig.getQA_dbPassword();

    //                      ############ --- UAT --- ############
    public String UAT_baseUri = appConfig.getUAT_baseUri();
    //                                 # --- DB --- #
    public String UAT_dbUrl = appConfig.getUAT_dbUrl();
    public String UAT_dbUserName = appConfig.getUAT_dbUserName();
    public String UAT_dbPassword = appConfig.getUAT_dbPassword();


    //                      ############ --- DEV --- ############
    public String DEV_baseUri = appConfig.getDEV_baseUri();
    //                                 # --- DB --- #
    public String DEV_dbUrl = appConfig.getDEV_dbUrl();
    public String DEV_dbUserName = appConfig.getDEV_dbUserName();
    public String DEV_dbPassword = appConfig.getDEV_dbPassword();

}
