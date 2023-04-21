package com.ciq.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LeaveTracker {

	@Column
	private int id;// 1,2,3,4
	@Column
	private int sickLeave = 3;
	@Column
	private int earnedLeave = 15;
	@Column
	private int meternityLeave = 180;
	@Column
	private int emergencyLeave = 7;

	public LeaveTracker() {
	}

	public LeaveTracker(int sickLeave, int earnedLeave, int meternityLeave, int emergencyLeave) {

		this.sickLeave = sickLeave;
		this.earnedLeave = earnedLeave;
		this.meternityLeave = meternityLeave;
		this.emergencyLeave = emergencyLeave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}

	public int getEarnedLeave() {
		return earnedLeave;
	}

	public void setEarnedLeave(int earnedLeave) {
		this.earnedLeave = earnedLeave;
	}

	public int getMeternityLeave() {
		return meternityLeave;
	}

	public void setMeternityLeave(int meternityLeave) {
		this.meternityLeave = meternityLeave;
	}

	public int getEmergencyLeave() {
		return emergencyLeave;
	}

	public void setEmergencyLeave(int emergencyLeave) {
		this.emergencyLeave = emergencyLeave;
	}

	@Override
	public String toString() {
		return "LeaveTracker [id=" + id + ", sickLeave=" + sickLeave + ", earnedLeave=" + earnedLeave
				+ ", meternityLeave=" + meternityLeave + ", emergencyLeave=" + emergencyLeave + "]";
	}

}
