(ns atv.notas)

(defn classificar-conceito [nota]
  (cond
    (>= nota 90) "A"
    (>= nota 80) "B"
    (>= nota 70) "C"
    (>= nota 60) "D"
    :else "F"))

(defn ler-nota []
  (println "Nota:")
  (Integer/parseInt (read-line)))

(defn ler-aluno [num]
  (println (str "Nome do aluno " num ":"))
  (let [nome (read-line)
        nota (ler-nota)
        conceito (classificar-conceito nota)]
    (println (str nome " - Conceito: " conceito))
    (println) ;; linha em branco para pular uma linha
    {:nome nome :nota nota :conceito conceito}))



(defn ler-alunos [quantidade]
  (loop [i 1
         alunos []]
    (if (<= i quantidade)
      (recur (inc i) (conj alunos (ler-aluno i)))
      alunos)))

(defn calcular-media [alunos]
  (/ (reduce + (map :nota alunos)) (count alunos)))

(defn contar-aprovados [alunos]
  (count (filter #(>= (:nota %) 60) alunos)))

(defn exibir-desempenho [media]
  (cond
    (>= media 80) (println "Desempenho geral: Turma excelente!")
    (>= media 60) (println "Desempenho geral: Bom desempenho!")
    :else (println "Desempenho geral: É necessário melhorar!")))

(defn sistema-de-notas []
  (println "Quantos alunos na turma?")
  (let [quantidade (Integer/parseInt (read-line))
        alunos (ler-alunos quantidade)
        media (calcular-media alunos)
        aprovados (contar-aprovados alunos)]
    (println (str "Média da turma: " media))
    (println (str "Aprovados: " aprovados))
    (exibir-desempenho media)))

(defn -main []
  (sistema-de-notas))
