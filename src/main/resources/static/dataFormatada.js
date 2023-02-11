function dataFormatada(data) {
					var data = new Date(data),
						dia = data.getDate().toString().padStart(2, '0'),
						mes = (data.getMonth() + 1).toString().padStart(2, '0'),
						ano = data.getFullYear();
					return dia + "/" + mes + "/" + ano;
				}