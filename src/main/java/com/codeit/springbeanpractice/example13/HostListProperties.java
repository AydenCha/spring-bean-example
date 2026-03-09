package com.codeit.springbeanpractice.example13;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 이 클래스를 스프링 빈으로 등록
@ConfigurationProperties(prefix = "my")
// application.yml 에서 my 로 시작하는 설정 값을 바인딩
public class HostListProperties {

    // my.hosts 아래에 정의된 여러 개의 host 설정을 리스트로 받음
    private List<Host> hosts;

    // 중첩 설정 객체
    // my.hosts[n].host, my.hosts[n].port 구조와 매핑됨
    public static class Host {
        private String host;
        private String port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }
    }

    // hosts 전체 리스트 접근용 getter
    public List<Host> getHosts() {
        return hosts;
    }

    // ConfigurationProperties는 setter를 통해 값이 주입됨
    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
}
