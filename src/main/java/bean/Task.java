package bean;

import java.util.Objects;

public class Task {
	private int taskid;
	private String taskname;
	private String taskdate;
	private int taskstatus;
	private int regid;
	@Override
	public int hashCode() {
		return Objects.hash(regid, taskdate, taskid, taskname, taskstatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return regid == other.regid && Objects.equals(taskdate, other.taskdate) && taskid == other.taskid
				&& Objects.equals(taskname, other.taskname) && taskstatus == other.taskstatus;
	}
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskname=" + taskname + ", taskdate=" + taskdate + ", taskstatus="
				+ taskstatus + ", regid=" + regid + "]";
	}
	public Task(int taskid, String taskname, String taskdate, int taskstatus, int regid) {
		super();
		this.taskid = taskid;
		this.taskname = taskname;
		this.taskdate = taskdate;
		this.taskstatus = taskstatus;
		this.regid = regid;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskdate() {
		return taskdate;
	}
	public void setTaskdate(String taskdate) {
		this.taskdate = taskdate;
	}
	public int getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(int taskstatus) {
		this.taskstatus = taskstatus;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
}
