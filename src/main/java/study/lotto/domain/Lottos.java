package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(Lottos lottos) {
        this(lottos.lottos);
    }

    public int size() {
        return lottos.size();
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public WinningLottos ranks(LottoWinningNumber lottoWinningNumber) {
        List<LottoRank> lottoRanks = lottos.stream()
                .map(lotto -> lotto.rank(lottoWinningNumber))
                .collect(Collectors.toList());

        return new WinningLottos(lottoRanks);
    }

    @Override public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
