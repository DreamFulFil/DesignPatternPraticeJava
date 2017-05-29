package dream.state.pattern;

public interface VoteState {
	void vote(String user, String voteItem, VoteManager voteManager);
}
