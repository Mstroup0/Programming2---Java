
@SuppressWarnings("unchecked")
class Job
{
        public String jobName;
        public int arrivalTime;
        public int startTime;
        public int runTime;
        public int waitTime;
        public int turnTime;

	public Job()
	{
		jobName = "";
		arrivalTime = 0;  startTime = 0;  runTime = 0;
		waitTime = 0;  turnTime = 0;
	}

	public Job (String jobName, int arrivalTime, int runTime)
	{
		this.jobName = jobName;
		this.arrivalTime = arrivalTime;
		this.runTime = runTime;
		this.startTime = -1;
	}

	public String toString()
	{
		return (jobName + "\t" +
	                arrivalTime + "\t" +
			startTime + "\t" +
	                runTime + "\t" +
                        waitTime + "\t" +
                        turnTime);
	}

	public String getName(){
		return jobName;
	}

	public int getArrival(){
		return arrivalTime;

	}

	public int getRTime(){
		return runTime;
	}

	public int getWait(){
		return waitTime;
	}

	public int getTurn(){
		return turnTime;

	}
  public int getTime(){
    return startTime;
  }

	public void setTurn(int turn){

	 this.turnTime = turn;

	}

	public void setStart(int time){
		this.startTime = time;

	}

	public void setWait(int wait){
		this. waitTime = wait;

	}
}
