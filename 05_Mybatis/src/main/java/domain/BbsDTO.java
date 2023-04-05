package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

// @Data는 toString(), getter() setter()을 만들어준다.
public class BbsDTO {
	
	private int bbsNo;
	private String title;
	private String content;
	private String modifiedDate;
	private String createdDate;
	

}
