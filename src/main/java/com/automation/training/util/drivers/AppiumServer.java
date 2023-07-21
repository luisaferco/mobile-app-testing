package com.automation.training.util.drivers;

import com.automation.training.exceptions.FailedUrlConnectionException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automation.training.exceptions.FailedUrlConnectionException.FAILED_URL_CALLING;

/**
 * AppiumServerAddress class to create the URL remote address
 * to communicate with the Appium server
 * @author luisaferco
 */
public class AppiumServer {

      private String server;
      private String username;
      private String password;
      private URL remoteAddress;

      public AppiumServer(String username, String password, String serverIp) {
            this.username = username;
            this.password = password;
            this.server = serverIp;
      }
      public URL getRemoteAddress(){
            return remoteAddress;
      }
      public void createUrlAddress() {
            try {
                  this.remoteAddress = new URL(String.format("https://%s:%s@%s/wd/hub",username,password,server));
            } catch (MalformedURLException e) {
                  throw new FailedUrlConnectionException(String.format(FAILED_URL_CALLING, e.getMessage()));
            }
      }

      public void setLocalAddress() {
            AppiumDriverLocalService localService = AppiumDriverLocalService.buildDefaultService();
            this.remoteAddress =  localService.getUrl();
      }

      public String getPassword() {
            return password;
      }
}
