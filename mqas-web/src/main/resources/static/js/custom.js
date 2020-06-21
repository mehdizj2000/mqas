$(document)
		.ready(
				function() {
					alert('[[${apiUrl}]]');

					// the custom
					var addresses = new Bloodhound({
						datumTokenizer : Bloodhound.tokenizers.whitespace,
						queryTokenizer : Bloodhound.tokenizers.whitespace,
						remote : {
							url : 'http://127.0.0.1:8595/api/getAddress/',
//							url : '#{solr.api.url}',
							prepare : function(query, settings) {
								settings.url = this.url
										+ query.trim().replace(/\W+/g, ',');
								console.log(settings.url);
								return settings;
							}
						}
					});

					$('#the-custom .typeahead')
							.typeahead(
									{
										hint : true,
										highlight : true,
										minLength : 5
									},
									{
										name : 'addresses',
										source : addresses,
										display : function(item) {
											return item.flatType + ' '
													+ item.flatNumber + '/'
													+ item.numberFirst + ' '
													+ item.streetName + ' '
													+ item.streetTypeCode + ' '
													+ item.localityName + ' '
													+ item.postcode + ' '
													+ item.stateAbbreviation;
										},
										templates : {
											empty : [
													'<div class="empty-message">',
													'unable to find any Best Picture winners that match the current query',
													'</div>' ].join('\n'),
											suggestion : Handlebars
													.compile('<div>{{flatType}} {{flatNumber}}/{{numberFirst}} {{streetName}} {{streetTypeCode}} {{localityName}} {{postcode}} {{stateAbbreviation}}</div>')
										}
									});

				});
