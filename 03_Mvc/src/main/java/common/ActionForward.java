package common;

public class ActionForward {

	private String path;		// 응답 경로(Jsp 이름)
	private boolean isRedirect; // 이동 방식(true이면 redirect, fasle면 forward
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
