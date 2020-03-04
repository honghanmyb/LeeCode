import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        int hostNameEndIndex = startUrl.indexOf('/', 7);
        String hostName = hostNameEndIndex == -1 ? startUrl : startUrl.substring(0, hostNameEndIndex);
        Set<String> urlSet = new HashSet<>();
        findAllUrls(hostName, urlSet, htmlParser, startUrl);
        return new ArrayList<>(urlSet);
    }

    private void findAllUrls(String hostName, Set<String> urlSet, HtmlParser htmlParser, String curUrl){
        if(urlSet.contains(curUrl)){
            return;
        }
        urlSet.add(curUrl);
        List<String> urls = htmlParser.getUrls(curUrl);
        for(String url : urls){
            if(url.startsWith(hostName)){
                findAllUrls(hostName, urlSet, htmlParser, url);
            }
        }
    }

    private class HtmlParser{
        List<String> getUrls(String url){
            return new ArrayList<>();
        }
    }
}
