package com.soapmans.changya.entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeathCheckInParam {
    private QuestionContentEntry questionContent;
    private Integer source;
    private String lobNumber;
}
