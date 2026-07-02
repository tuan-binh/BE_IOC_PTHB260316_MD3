package org.example.chua_bai_ss01.models.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignmentReq {
    private Integer userId;
    private Integer taskId;
}
