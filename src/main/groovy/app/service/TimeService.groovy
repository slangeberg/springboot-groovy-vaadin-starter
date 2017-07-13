package app.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import java.time.Instant

/**
 * Let's start the day right
 */
@Slf4j
@Service
class TimeService {
    Instant getCurrentTime() {
        log.info "getCurrentTime()"
        Instant.now()
    }
}