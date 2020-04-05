package study.lotto.domain;

public class LottoResult {
    private WinningLottos winningLottos;
    private Amount investmentAmount;

    public LottoResult(WinningLottos winningLottos,
                       Amount investmentAmount) {
        this.winningLottos = winningLottos;
        this.investmentAmount = investmentAmount;
    }

    protected LottoResult(WinningLottos winningLottos,
                          int investmentAmount) {
        this(winningLottos, new Amount(investmentAmount));
    }

    public double getRateOfReturn() {
        double prizeTotal = this.winningLottos.getPrizeTotal();
        return prizeTotal / investmentAmount.getValue();
    }

    public int getWinningCount(LottoRank lottoRank) {
        return winningLottos.count(lottoRank);
    }
}
