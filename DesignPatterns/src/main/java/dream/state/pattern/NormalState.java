package dream.state.pattern;

public class NormalState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager){
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("您已成功投票！");
		voteManager.getMapState().put(user, new RepeatVoteState());
	}
}
