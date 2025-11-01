package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        validate(lottos);

        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    private static void validate(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalStateException("[ERROR] 로또 목록이 비어있으면 안 됩니다.");
        }
    }
}
