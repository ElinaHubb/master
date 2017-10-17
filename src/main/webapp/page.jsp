<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оценка личности</title>
</head>
<body>
<br>
<br>
<CENTER>
    <form action="diagram" method="post">
        <table>
            <caption style="font-size: 20pt">Оценка себя</caption>
            <tr>
                <td colspan="4" align="center">Оцените себя по каждому параметру от 0 до 10<td>
            </tr>
            <tr>
                <td colspan="4"><br><td>
            </tr>
            <tr>
                <td colspan="2"><b>ЗДОРОВЬЕ</b></td>
                <td colspan="2"><b>ЯРКОСТЬ ЖИЗНИ</b></td>
            </tr>
            <tr>
                <td>Внешний вид. <em>0 - выгляжу как орк. 10 - бесподобно выгляжу</em></td>
                <td style="padding-right:15px"><input type="number" max="10" min="0" value="${health_1}" name="health_1"/></td>
                <td>Развлечение. <em>0 - некогда заниматься и не на что. 10 - отрываюсь по полной</em></td>
                <td><input type="number" max="10" min="0" value="${fun_1}" name="fun_1"/></td>
            </tr>
            <tr>
                <td>Питание. <em>0 - жру все подряд. 10 - тщательно слежу за потребляемой пищей</em></td>
                <td><input type="number" max="10" min="0" value="${health_2}" name="health_2"/></td>
                <td>Отдых. <em>0 - валяюсь на диване. 10 - активная форма отдыха</em></td>
                <td><input type="number" max="10" min="0" value="${fun_2}" name="fun_2"/></td>
            </tr>
            <tr>
                <td>Физическая культура. <em>0 - между диваном и креслом. 10 - занимаюсь спортом</em></td>
                <td><input type="number" max="10" min="0" value="${health_3}" name="health_3"/></td>
                <td>Хобби. <em>0 - нет хобби. 10 - имею полезные и увлекательные хобби</em></td>
                <td><input type="number" max="10" min="0" value="${fun_3}" name="fun_3"/></td>
            </tr>
            <tr>
                <td>Сон и режим. <em>0 - сплю постоянно или недосыпаю. 10 - высыпаюсь по графику</em></td>
                <td><input type="number" max="10" min="0" value="${health_4}" name="health_4"/></td>
                <td>Путешествия. <em>0 - сижу дома. 10 - провожу хотя бы 2-3 месяца в год в других странах</em></td>
                <td><input type="number" max="10" min="0" value="${fun_4}" name="fun_4"/></td>
            </tr>
            <tr>
                <td>Самочувствие и здоровье. <em>0 - хронически болею. 10 - не болею совсем</em></td>
                <td><input type="number" max="10" min="0" value="${health_5}" name="health_5"/></td>
                <td>Впечатления. <em>0 - жизнь боль и мрак. 10 - яркая и насыщенная жизнь</em></td>
                <td><input type="number" max="10" min="0" value="${fun_5}" name="fun_5"/></td>
            </tr>
            <tr>
                <td>Настроение. <em>0 - хроническая депрессия. 10 - постоянный позитив</em></td>
                <td><input type="number" max="10" min="0" value="${health_6}" name="health_6"/></td>
            </tr>
            <tr>
                <td>Активность. <em>0 - едва ползаю. 10 - успеваю сделать много конструктивных дел за день</em></td>
                <td><input type="number" max="10" min="0" value="${health_7}" name="health_7"/></td>
            </tr>
            <tr>
                <td colspan="2"><br></td>
                <td colspan="2"><br></td>
            </tr>
            <tr>
                <td colspan="2"><b>ОКРУЖЕНИЕ</b></td>
                <td colspan="2"><b>ОБЕСПЕЧЕННОСТЬ</b></td>
            </tr>
            <tr>
                <td>Родственники. <em>0 - ненавидим друг друга. 10 - общаемся и помогаем друг другу</em></td>
                <td><input type="number" max="10" min="0" value="${environment_1}" name="environment_1"/></td>
                <td>Условия жизни. <em>0 - живу с кем придется. 10 - есть своя недвижимость</em></td>
                <td><input type="number" max="10" min="0" value="${rich_1}" name="rich_1"/></td>
            </tr>
            <tr>
                <td>Коллеги. <em>0 - редкостные сволочи. 10 - дружба и уважение</em></td>
                <td><input type="number" max="10" min="0" value="${environment_2}" name="environment_2"/></td>
                <td>Уровень дохода. <em>0 - живу в долг и на кредиты. 10 - доход высокий и стабильный</em></td>
                <td><input type="number" max="10" min="0" value="${rich_2}" name="rich_2"/></td>
            </tr>
            <tr>
                <td>Количество друзей. <em>0 - чувствую одиночество. 10 - мне хватает друзей</em></td>
                <td><input type="number" max="10" min="0" value="${environment_3}" name="environment_3"/></td>
                <td>Источники дохода. <em>0 - нахожусь на содержании. 10 - имею несколько источников дохода</em></td>
                <td><input type="number" max="10" min="0" value="${rich_3}" name="rich_3"/></td>
            </tr>
            <tr>
                <td>Соседи. <em>0 - знать их не хочу. 10 - общаемся иногда даже помогаем друг другу</em></td>
                <td><input type="number" max="10" min="0" value="${environment_4}" name="environment_4"/></td>
                <td>Подушка безопасности. <em>0 - нету. 10 - есть накопления, активы и недвижимость</em></td>
                <td><input type="number" max="10" min="0" value="${rich_4}" name="rich_4"/></td>
            </tr>
            <tr>
                <td>Люди. <em>0 - их для меня не существует. 10 - общаюсь даже с незнакомыми людьми</em></td>
                <td><input type="number" max="10" min="0" value="${environment_5}" name="environment_5"/></td>
                <td>Доходы/расходы. <em>0 - только трачу. 10 - мои доходы многократно превышают мои расходы</em></td>
                <td><input type="number" max="10" min="0" value="${rich_5}" name="rich_5"/></td>
            </tr>
        </table>
        <br>
        <input type="submit" style="height: 40px; width: 180px; font-size: 15pt" value="Вычислить"/>
    </form>
</CENTER>

</body>
</html>
