package dream.state.pattern;

public class BlackVoteState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("進入黑名單，將禁止登入和使用本系統！");
	}
}
