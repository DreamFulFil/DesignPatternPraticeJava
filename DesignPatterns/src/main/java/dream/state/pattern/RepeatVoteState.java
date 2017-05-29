package dream.state.pattern;

public class RepeatVoteState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("請不要重覆投票！");
		if(voteManager.getMapVoteCount().get(user) >= 4){
			voteManager.getMapState().put(user, new SpiteVoteState());
		}
	}
}
