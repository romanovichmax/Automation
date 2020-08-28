package io.ctdev;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:SystemConfig.properties")
public interface SystemConfig extends Config {

    SystemConfig config = ConfigFactory.create(SystemConfig.class, System.getenv(), System.getProperties());

    @Key("url.google")
    String googleUrl();

    @Key("url.instagram")
    String instagramUrl();

    @Key("url.facebook")
    String facebookUrl();

    @Key("title.google")
    String googleTitle();

    @Key("title.instagram")
    String instagramTitle();

    @Key("title.facebook")
    String facebookTitle();
}