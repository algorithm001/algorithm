package id_123

import "testing"

func Test_longestWord(t *testing.T) {
	type args struct {
		words []string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "test1",
			args: args{
				words: []string{"w", "wo", "wor", "worl", "world"},
			},
			want: "world",
		},
		{
			name: "test2",
			args: args{
				words: []string{"b", "bo", "boy", "w", "wo", "wor", "worl", "world"},
			},
			want: "world",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := longestWord(tt.args.words); got != tt.want {
				t.Errorf("longestWord() = %v, want %v", got, tt.want)
			}
		})
	}
}
