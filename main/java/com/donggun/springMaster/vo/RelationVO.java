package com.donggun.springMaster.vo;

/**
 * 팔로워, 팔로잉, 차단 등 타 유저와의 관계 정보 VO
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0 
 */
public class RelationVO {

	private String id;			// FK
	private String componentId; // PK
	private boolean followYn;
	private boolean followingYn;
	private boolean blockYn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}
	public boolean isFollowYn() {
		return followYn;
	}
	public void setFollowYn(boolean followYn) {
		this.followYn = followYn;
	}
	public boolean isFollowingYn() {
		return followingYn;
	}
	public void setFollowingYn(boolean followingYn) {
		this.followingYn = followingYn;
	}
	public boolean isBlockYn() {
		return blockYn;
	}
	public void setBlockYn(boolean blockYn) {
		this.blockYn = blockYn;
	}
	
}
