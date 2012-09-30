
-- AM_FORUM --
SELECT CD_PESSOA_FORUM, DS_FORUM FROM AM_FORUM;
SELECT CD_PESSOA_FORUM, DS_FORUM FROM AM_FORUM WHERE CD_PESSOA_FORUM = ?;
------------------------------------------------------------------

-- AM_CLIENTE --

SELECT CD_PESSOA_CLIENTE, NM_RAZAO_SOCIAL, NR_CNPJ, NR_INSC_ESTADUAL, DS_EMAIL, DS_PASSWORD FROM AM_CLIENTE;
SELECT CD_PESSOA_CLIENTE, NM_RAZAO_SOCIAL, NR_CNPJ, NR_INSC_ESTADUAL, DS_EMAIL, DS_PASSWORD FROM AM_CLIENTE WHERE CD_PESSOA_CLIENTE = ?;
------------------------------------------------------------------

-- AM_TIPO_CAUSA --
SELECT CD_CAUSA, DS_CAUSA FROM AM_TIPO_CAUSA;
SELECT CD_CAUSA, DS_CAUSA FROM AM_TIPO_CAUSA WHERE CD_CAUSA = ?;
------------------------------------------------------------------

-- AM_TIPO_COBRANCA --
SELECT CD_COBRANCA, DS_COBRANCA, TX_JUROS, VL_MORA_DIARIA FROM AM_TIPO_COBRANCA;
SELECT CD_COBRANCA, DS_COBRANCA, TX_JUROS, VL_MORA_DIARIA FROM AM_TIPO_COBRANCA WHERE CD_COBRANCA = ?;
------------------------------------------------------------------

-- AM_PROCESSO --
SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA,  DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO FROM AM_PROCESSO WHERE DT_FECHAMENTO IS NULL;
SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA,  DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO FROM AM_PROCESSO WHERE NR_PROCESSO = ?;
INSERT INTO AM_PROCESSO (CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO, DT_ABERTURA, DD_DIA_VENCIMENTO, DS_OBSERVACAO) VALUES (?,?,?,?,?,?,?,?);
------------------------------------------------------------------

-- AM_TIPO_DESPESA --
SELECT CD_DESPESA, DS_DESPESA FROM AM_TIPO_DESPESA;
SELECT CD_DESPESA, DS_DESPESA FROM AM_TIPO_DESPESA WHERE CD_DESPESA = ?;
------------------------------------------------------------------

-- AM_DESPESA --
SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO FROM AM_DESPESA;
SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO FROM AM_DESPESA WHERE CD_LANCAMENTO = ?;
SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO FROM AM_DESPESA WHERE NR_PROCESSO = ?
INSERT INTO AM_DESPESA(CD_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?,?,?,?,?);
UPDATE AM_DESPESA SET VL_DESPESA = ?, DS_OBSERVACAO = ? WHERE CD_LANCAMENTO = ?;
SELECT sum(VL_DESPESA) FROM AM_DESPESA WHERE NR_PROCESSO = ? GROUP BY NR_PROCESSO;
DELETE FROM AM_DESPESA WHERE CD_LANCAMENTO = ?;

------------------------------------------------------------------

--AM_ADVOGADO --
SELECT CD_PESSOA_ADV, NR_OAB,  NR_CPF,  NR_RG,  DS_EMAIL,  DS_PASSWORD FROM AM_ADVOGADO;
SELECT CD_PESSOA_ADV, NR_OAB,  NR_CPF,  NR_RG,  DS_EMAIL,  DS_PASSWORD FROM AM_ADVOGADO WHERE CD_PESSOA_ADV = ?;
------------------------------------------------------------------

--AM_TAREFA --
SELECT CD_TAREFA, DS_TAREFA FROM AM_TAREFA;
-----------------------------------------------------------------

--AM_TITULO -- 
SELECT NR_TITULO, NR_PROCESSO, NR_AGENCIA_CEDENTE, DT_DOCUMENTO, DT_VENCIMENTO, VL_DOCUMENTO FROM AM_TITULO WHERE NR_PROCESSO = ?;
-------------------------------------------------------------------

--RELAT�RIO DE AUDI�NCIAS POR PROCESSO
SELECT agenda.DT_HORA_AGENDA AS DATA, pessoa_forum.NM_PESSOA AS FORUM, endereco.NM_LOGRADOURO AS ENDERECO_FORUM, 
		pe_endereco.NR_ENDERECO AS NUMERO_FORUM, agenda.SL_FORUM AS SALA, pessoa.NM_PESSOA AS ADVOGADO
FROM AM_AGENDA_AUDIENCIA agenda
LEFT JOIN AM_PESSOA pessoa ON pessoa.CD_PESSOA = agenda.CD_PESSOA_ADV
LEFT JOIN AM_PROCESSO processo ON processo.NR_PROCESSO = agenda.NR_PROCESSO
LEFT JOIN AM_PESSOA pessoa_forum ON pessoa_forum.CD_PESSOA = processo.CD_PESSOA_FORUM
LEFT JOIN AM_PESSOA_ENDERECO pe_endereco ON pe_endereco.CD_PESSOA = pessoa_forum.CD_PESSOA
LEFT JOIN AM_ENDERECO endereco ON endereco.CD_ENDERECO = pe_endereco.CD_ENDERECO
WHERE processo.NR_PROCESSO = ?
ORDER BY agenda.DT_HORA_AGENDA DESC
--------------------------------------------------------------------

--RELAT�RIO DE HONOR�RIOS POR PROCESSO
SELECT adv_honorario.DT_HONORARIO AS DATA, pessoa.NM_PESSOA AS ADVOGADO, SUM(adv_hora.VL_HORA * adv_honorario.QT_HORAS) AS VALOR_TAREFA
FROM AM_ADVOGADO_HONORARIO adv_honorario
LEFT JOIN AM_PESSOA pessoa ON pessoa.CD_PESSOA = adv_honorario.CD_PESSOA_ADV
LEFT JOIN AM_HORA_ADVOGADO adv_hora ON adv_hora.CD_PESSOA_ADV = adv_honorario.CD_PESSOA_ADV
LEFT JOIN AM_ADVOGADO_PROCESSO adv_processo ON adv_processo.CD_PESSOA_ADV = adv_honorario.CD_PESSOA_ADV
LEFT JOIN AM_PROCESSO processo ON processo.NR_PROCESSO = adv_processo.NR_PROCESSO
LEFT JOIN AM_TAREFA tarefa ON tarefa.CD_TAREFA = adv_honorario.CD_TAREFA
WHERE processo.NR_PROCESSO = ?
AND tarefa.CD_TAREFA = ?
GROUP BY adv_honorario.DT_HONORARIO, pessoa.NM_PESSOA
ORDER BY 1 DESC
---------------------------------------------------------------------