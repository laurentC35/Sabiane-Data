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
    
    <xsl:template match="@*|node()" mode="withoutRepeat">
        <xsl:if test="local-name(.)!='number-columns-repeated'">
            <xsl:copy>
                <xsl:apply-templates select="@*|node()" mode="withoutRepeat"/>
            </xsl:copy>
        </xsl:if>       
    </xsl:template>
    
    <xsl:template match="/">
        <Campaign>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='campaign']"/>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='organisationalUnits']"/>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='surveyUnits']"/>
        </Campaign>
    </xsl:template>
    
    
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='campaign']">
        <xsl:variable name="row" select="tools:get-full-row(table:table-row[2])"/>
        <Id><xsl:value-of select="lower-case(tools:getColumn($row,1))"/></Id>
        <Label><xsl:value-of select="tools:getColumn($row,2)"/></Label>
        <StartDate><xsl:value-of select="tools:getColumn($row,3)"/></StartDate>
        <EndDate><xsl:value-of select="tools:getColumn($row,4)"/></EndDate>
    </xsl:template>
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='organisationalUnits']">
        <OrganizationalUnits>
            <xsl:for-each select="table:table-row[position()>1]">
                <xsl:variable name="row" select="tools:get-full-row(.)"/>
                <xsl:if test="normalize-space($row)!=''">
                    <OrganizationalUnit>
                        <Id><xsl:value-of select="tools:getColumn($row,1)"/></Id>
                        <CollectionStartDate><xsl:value-of select="tools:getColumn($row,2)"/></CollectionStartDate>
                        <CollectionEndDate><xsl:value-of select="tools:getColumn($row,3)"/></CollectionEndDate>
                        <IdentificationPhaseStartDate><xsl:value-of select="tools:getColumn($row,4)"/></IdentificationPhaseStartDate>
                        <InterviewerStartDate><xsl:value-of select="tools:getColumn($row,5)"/></InterviewerStartDate>
                        <ManagementStartDate><xsl:value-of select="tools:getColumn($row,6)"/></ManagementStartDate>
                        <EndDate><xsl:value-of select="tools:getColumn($row,7)"/></EndDate>
                    </OrganizationalUnit>
                </xsl:if>                
            </xsl:for-each>
        </OrganizationalUnits>
    </xsl:template>
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='surveyUnits']">
        <SurveyUnits>
            <xsl:for-each select="table:table-row[position()>1]">
                <xsl:variable name="row" select="tools:get-full-row(.)"/>
                <xsl:if test="normalize-space($row)!=''">
                    <SurveyUnit>
                        <Id><xsl:copy-of select="tools:getColumn($row,1)"/></Id>
                        <InterwieverId><xsl:value-of select="tools:getColumn($row,2)"/></InterwieverId>
                        <FirstName><xsl:value-of select="tools:getColumn($row,3)"/></FirstName>
                        <LastName><xsl:value-of select="tools:getColumn($row,4)"/></LastName>
                        <Priority><xsl:value-of select="tools:getColumn($row,5)"/></Priority>
                        <PhoneNumbers>
                            <xsl:for-each select="tokenize(tools:getColumn($row,6),',')">
                                <PhoneNumber><xsl:value-of select="."/></PhoneNumber>
                            </xsl:for-each>
                        </PhoneNumbers>
                        <InseeAddress>
                            <GeographicalLocationId><xsl:value-of select="tools:getColumn($row,7)"/></GeographicalLocationId>
                            <L1><xsl:value-of select="tools:getColumn($row,8)"/></L1>
                            <L2><xsl:value-of select="tools:getColumn($row,9)"/></L2>
                            <L3><xsl:value-of select="tools:getColumn($row,10)"/></L3>
                            <L4><xsl:value-of select="tools:getColumn($row,11)"/></L4>
                            <L5><xsl:value-of select="tools:getColumn($row,12)"/></L5>
                            <L6><xsl:value-of select="tools:getColumn($row,13)"/></L6>
                            <L7><xsl:value-of select="tools:getColumn($row,14)"/></L7>
                        </InseeAddress>
                        <InseeSampleIdentiers>
                            <Bs><xsl:value-of select="tools:getColumn($row,15)"/></Bs>
                            <Ec><xsl:value-of select="tools:getColumn($row,16)"/></Ec>
                            <Le><xsl:value-of select="tools:getColumn($row,17)"/></Le>
                            <Noi><xsl:value-of select="tools:getColumn($row,18)"/></Noi>
                            <Numfa><xsl:value-of select="tools:getColumn($row,19)"/></Numfa>
                            <Rges><xsl:value-of select="tools:getColumn($row,20)"/></Rges>
                            <Ssech><xsl:value-of select="tools:getColumn($row,21)"/></Ssech>
                            <Nolog><xsl:value-of select="tools:getColumn($row,22)"/></Nolog>
                            <Nole><xsl:value-of select="tools:getColumn($row,23)"/></Nole>
                            <Autre><xsl:value-of select="tools:getColumn($row,24)"/></Autre>
                            <Nograp><xsl:value-of select="tools:getColumn($row,25)"/></Nograp>
                        </InseeSampleIdentiers>
                    </SurveyUnit>
                </xsl:if>
            </xsl:for-each>
        </SurveyUnits>
    </xsl:template>
</xsl:stylesheet>