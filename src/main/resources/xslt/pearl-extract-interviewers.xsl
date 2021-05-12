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
    
    <xsl:import href="./utils.xsl"/>    
    <xsl:output indent="yes"/>
    
    <xsl:template match="/">
        <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='interviewers']"/>
    </xsl:template>
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='interviewers']">
        <Interviewers>
            <xsl:for-each select="table:table-row[position()>1]">
                <xsl:variable name="row" select="tools:get-full-row(.)"/>
                <xsl:if test="normalize-space($row)!=''">
                    <Interviewer>
                        <Id><xsl:value-of select="tools:getColumn($row,1)"/></Id>
                        <FirstName><xsl:value-of select="tools:getColumn($row,2)"/></FirstName>
                        <LastName><xsl:value-of select="tools:getColumn($row,3)"/></LastName>
                        <Email><xsl:value-of select="tools:getColumn($row,4)"/></Email>
                        <PhoneNumber><xsl:value-of select="tools:getColumn($row,5)"/></PhoneNumber>
                    </Interviewer>
                </xsl:if>                
            </xsl:for-each>
        </Interviewers>
    </xsl:template>
</xsl:stylesheet>