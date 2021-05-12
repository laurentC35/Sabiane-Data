<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
    xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
    xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
    xmlns:tools="http://www.insee.fr/tools"
    office:version="1.2" office:mimetype="application/vnd.oasis.opendocument.spreadsheet"
    exclude-result-prefixes="tools xs office text table "
    version="2.0"> 
    
    <xsl:template match="@*|node()" mode="withoutRepeat">
        <xsl:if test="local-name(.)!='number-columns-repeated'">
            <xsl:copy>
                <xsl:apply-templates select="@*|node()" mode="withoutRepeat"/>
            </xsl:copy>
        </xsl:if>       
    </xsl:template>
        
    <xsl:function name="tools:get-full-row">
        <xsl:param name="row" as="node()"/>        
        <table:table-row>
            <xsl:for-each select="$row/table:table-cell">
                <xsl:choose>
                    <xsl:when test=".[@table:number-columns-repeated!='' and number(@table:number-columns-repeated)&lt;30]">
                        <xsl:variable name="newCell">                            
                            <xsl:apply-templates select="." mode="withoutRepeat"/>
                        </xsl:variable>
                        <xsl:call-template name="copyNTimes">
                            <xsl:with-param name="nodeToCopy" select="$newCell"/>
                            <xsl:with-param name="N" select="number(@table:number-columns-repeated)"/>
                        </xsl:call-template>
                    </xsl:when>
                    <xsl:otherwise><xsl:copy-of select="."/></xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table:table-row>
    </xsl:function>
    
    <xsl:template name="copyNTimes">
        <xsl:param name="nodeToCopy"/>
        <xsl:param name="N"/>
        <xsl:if test="$N>0">
            <xsl:copy-of select="$nodeToCopy"/>
            <xsl:call-template name="copyNTimes">
                <xsl:with-param name="nodeToCopy" select="$nodeToCopy"/>
                <xsl:with-param name="N" select="$N -1"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
    
    <xsl:function name="tools:getColumn">
        <xsl:param name="row" as="node()"/>
        <xsl:param name="column" as="xs:integer"/>
        <xsl:value-of select="normalize-space($row/table:table-cell[$column])"/>
    </xsl:function>
</xsl:stylesheet>