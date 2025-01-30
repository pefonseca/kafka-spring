package com.pefonseca.payment.service.core.dto;

import com.pefonseca.payment.service.core.enums.ESagaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private String id;
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private ESagaStatus status;
    private List<History> eventHistory;

    public void addToHistory(History history) {
        if(ObjectUtils.isEmpty(this.eventHistory)) {
            this.eventHistory = new ArrayList<>();
        }
        this.eventHistory.add(history);
    }

}
