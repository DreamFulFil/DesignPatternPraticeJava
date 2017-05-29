package dream.state.pattern;

public class NormalState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager){
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("恭禧你投票成功！");
		voteManager.getMapState().put(user, new RepeatVoteState());
	}
}
