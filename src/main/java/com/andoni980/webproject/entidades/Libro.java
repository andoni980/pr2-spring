package com.andoni980.webproject.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "No puede estar vacío")
	@Size(min=3,max=150)
	@Column(name = "titulo")
	private String titulo;
	
	@Lob
	@NotNull(message = "No puede estar vacío")
	@Size(min=3,max=3000)
	@Column(name = "descripcion")
	@Builder.Default
	private String descripcion = "NO CONTIENE UNA DESCRIPCIÓN";
	
	@NotNull(message = "No puede estar vacío")
	@Min(0)
	@Column(name = "precio")
	private BigDecimal precio;
	
	@NotNull(message = "El descuento es un dato obligatorio")
	@Min(0)
	@Max(100)
	@Column(name = "descuento")
	@Builder.Default
	private Integer descuento = 0;
	
	@NotNull(message = "El ISBN es un dato obligatorio")
	@Pattern(regexp = "^\\d{13}$", message = "Debe tener 13 digitos")
	@Column(name = "isbn", columnDefinition = "CHAR(13)")
	private String isbn;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor_id")
	private Autor autor;

}
