package com.seeyii.bigdata.core;

/**
 * <b><code>SparkConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/4/12 10:05.
 *
 * @author Hu-Weihui
 * @since hui-bigdata-springboot ${PROJECT_VERSION}
 */
//@Component
//@ConfigurationProperties(prefix = "spark")
//@Data
public class SparkConfig {
    private String appName;

    private String master;

    private String sparkHome;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getSparkHome() {
        return sparkHome;
    }

    public void setSparkHome(String sparkHome) {
        this.sparkHome = sparkHome;
    }
}
