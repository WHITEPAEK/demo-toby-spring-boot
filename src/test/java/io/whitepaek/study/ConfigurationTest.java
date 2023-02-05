package io.whitepaek.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean01 bean01 = ac.getBean(Bean01.class);
        Bean02 bean02 = ac.getBean(Bean02.class);

        assertThat(bean01.common).isSameAs(bean02.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();
        Bean01 bean01 = myConfigProxy.bean01();
        Bean02 bean02 = myConfigProxy.bean02();

        assertThat(bean01.common).isSameAs(bean02.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();
            return this.common;
        }
    }

    @Configuration
    static class MyConfig {

        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean01 bean01() {
            return new Bean01(common());
        }

        @Bean
        Bean02 bean02() {
            return new Bean02(common());
        }

    }

    static class Bean01 {
        private final Common common;

        Bean01(Common common) {
            this.common = common;
        }
    }

    static class Bean02 {
        private final Common common;

        Bean02(Common common) {
            this.common = common;
        }
    }

    static class Common {
    }

}
