package dream.state.pattern;

public class BlackVoteState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("您無權投票！");
	}
}
