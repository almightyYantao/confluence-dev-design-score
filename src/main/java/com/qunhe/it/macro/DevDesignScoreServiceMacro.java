package com.qunhe.it.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.webresource.api.assembler.PageBuilderService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
public class DevDesignScoreServiceMacro implements Macro {

    private static final Logger log = Logger.getLogger(DevDesignScoreServiceMacro.class);

    private PageBuilderService pageBuilderService;

    @Inject
    public DevDesignScoreServiceMacro(
            @ComponentImport PageBuilderService pageBuilderService
    ) {
        this.pageBuilderService = pageBuilderService;
    }


    @Override
    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {
        pageBuilderService.assembler().resources().requireWebResource("com.qunhe.it.DevDesignScoreMacro:DevDesignScoreMacro-resources");
        return "<span class=\"devDesignScore\">" + s + "</span>";
//        StringBuilder result = new StringBuilder("<table class=\"wrapped confluenceTable tablesorter tablesorter-default stickyTableHeaders\"><tbody>");
//        String[] fileThs = map.get("fileThs").split(",");
//        StringBuilder th = new StringBuilder("<tr>");
//        StringBuilder td = new StringBuilder("<tr>");
//        for (String fileTh : fileThs) {
//            th.append("<th class=\"confluenceTh\">").append(fileTh).append("</th>");
//            td.append("<td class=\"confluenceTd\">").append("<br/>").append("</td>");
//        }
//        th.append("</tr>");
//        td.append("</tr>");
//        result.append(th).append(td).append("</tbody></table>");
//        result.append("<p>").append(conversionContext.getPageContext().toString()).append("</p>").append("123321");
//        return result.toString();
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.PLAIN_TEXT;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.INLINE;
    }
}
