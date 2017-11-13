package org.stenerud.kscrash;

import android.content.Context;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;




/**
 * 通过http请求接口上传crash日志
 */
public class KSCrashInstallationStandard extends KSCrashInstallation {

    /**
     * Constructor.
     *
     * @param context A context.
     * @param url The URL to post the reports to.
     */
    public KSCrashInstallationStandard(Context context, URL url) {
        super(context, generateFilters(url));
    }


    /**
     * 产生过滤器
     * @param url
     * @return
     */
    private static List<KSCrashReportFilter> generateFilters(URL url) {
        List<KSCrashReportFilter> reportFilters = new LinkedList<KSCrashReportFilter>();
        reportFilters.add(new KSCrashReportFilterJSONEncode(4));
        reportFilters.add(new KSCrashReportFilterGZipCompress());
        reportFilters.add(new KSCrashReportFilterHttp(url, "report", "json.gz"));
        return reportFilters;
    }
}
