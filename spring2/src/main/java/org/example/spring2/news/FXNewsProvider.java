package org.example.spring2.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FXNewsProvider {
    @Autowired
    private IFXNewsListener newsListener;
    @Autowired
    private IFXNewsPersister newPersistener;

    public void getAndPersistNews() {
        System.out.println("*******getAndPersistNews");
//        String[] newsIds = newsListener.getAvailableNewsIds();
//        if (ArrayUtils.isEmpty(newsIds)) {
//            return;
//        }
//        for (String newsId : newsIds) {
//            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
//            newPersistener.persistNews(newsBean);
//            newsListener.postProcessIfNecessary(newsId);
//        }
    }

    //    public FXNewsProvider() {
//        newsListener = new DowJonesNewsListener();
//        newPersistener = new DowJonesNewsPersister();
//    }
    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newPersistener) {
        this.newsListener = newsListener;
        this.newPersistener = newPersistener;
    }
}
